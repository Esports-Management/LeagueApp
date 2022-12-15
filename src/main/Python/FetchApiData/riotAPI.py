import riotwatcher
from datetime import datetime
import APIToMySQL
from requests import HTTPError
import sys
from config import getapikey


class Summoner:

    def __init__(self, summoner):
        self.name = summoner['name']
        self.id = summoner['id']
        self.account_id = summoner['accountId']
        self.level = summoner['summonerLevel']
        self.last_updated = datetime.fromtimestamp(summoner['revisionDate'] / 1000)
        self.puuid = summoner['puuid']
        self.queue = {}
        self.league_names = []

    def get_match_list(self, lol_watcher, region):
        self.match_list = lol_watcher.match.matchlist_by_puuid(region=region, puuid=self.puuid)

    def get_challenger_by_queue_ranked_solo_5x5(self, lol_watcher, region):
        self.queue.update(
            {"RANKED_SOLO_5x5": lol_watcher.league.challenger_by_queue(region=region, queue="RANKED_SOLO_5x5")})

    def get_challenger_by_queue_ranked_flex_sr(self, lol_watcher, region):
        self.queue.update(
            {"RANKED_FLEX_SR": lol_watcher.league.challenger_by_queue(region=region, queue="RANKED_FLEX_SR")})

    def get_queue(self, lol_watcher, region):
        self.queue.update({'all queues': lol_watcher.league.challenger_by_queue(region=region, queue="CUSTOM_GAME")})

    def get_league_info(self, lol_watcher, region):
        self.league = lol_watcher.league.by_summoner(region=region, encrypted_summoner_id=self.id)

        match_statistics = {}

        # for i in range(len(match_metadata['info']['participants'])):
        #     match_statistics.update({match_metadata['info']['participants'][i]['summonerName']: {}})
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['matchId'] = match_id
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['kills'] = \
        #         match_metadata['info']['participants'][i]['kills']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['deaths'] = \
        #         match_metadata['info']['participants'][i]['deaths']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['assists'] = \
        #         match_metadata['info']['participants'][i]['assists']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['firstBloodKill'] = \
        #         match_metadata['info']['participants'][i]['firstBloodKill']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['goldEarned'] = \
        #         match_metadata['info']['participants'][i]['goldEarned']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['pentaKills'] = \
        #         match_metadata['info']['participants'][i]['pentaKills']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['timeCCingOthers'] = \
        #         match_metadata['info']['participants'][i]['timeCCingOthers']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalTimeCCDealt'] = \
        #         match_metadata['info']['participants'][i]['totalTimeCCDealt']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalDamageDealtToChampions'] = \
        #         match_metadata['info']['participants'][i]['totalDamageDealtToChampions']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalMinionsKilled'] = \
        #         match_metadata['info']['participants'][i]['totalMinionsKilled']
        #     match_statistics[match_metadata['info']['participants'][i]['summonerName']]['visionScore'] = \
        #         match_metadata['info']['participants'][i]['visionScore']

        APIToMySQL.insert_to_match_statistics_table(match_statistics)
        return match_statistics

    def get_leagues_player_is_in(self):
        for queue in self.queue:
            for k, v in self.queue[queue].items():
                if k == 'entries':
                    for entry in self.queue[queue][k]:
                        if entry['summonerName'] != "moonou":
                            pass
                        else:
                            for key, value in entry.items():
                                print(key, value)
                            print("\n")
                else:
                    print(k, v)
                    if k == 'name':
                        self.league_names.append(v)

    def get_summoners_in_league(self, game_type, league_name):

        for i in range(len(self.queue[game_type]['entries'])):
            if self.queue[game_type]['name'] == league_name:
                print(self.queue[game_type]['entries'][i]['summonerName'],
                      self.queue[game_type]['entries'][i]['leaguePoints'],
                      self.queue[game_type]['tier']
                      )


def get_match_info_by_match_id(watcher, region, match_id):

    if len(match_id) > 15:
        match_ids_without_commas = match_id.replace(", ", " ")
        match_ids_without_commas_with_spaces = match_ids_without_commas.replace(",", " ")
        match_id_list = match_ids_without_commas_with_spaces.split(" ")

        for match_id_element in match_id_list:
            get_match_info_by_match_id(lol_watcher, region, match_id_element)
        return

    try:
        match_metadata = watcher.match.by_id(region, match_id)

        match_statistics = {}

        game_length_minutes = match_metadata['info']['gameDuration'] // 60
        game_length_seconds = match_metadata['info']['gameDuration'] % 60

        game_length_minutes_and_seconds = str(game_length_minutes) + "min. " + str(game_length_seconds) + 'sec.'

        for i in range(len(match_metadata['info']['participants'])):
            match_statistics.update(
                {match_metadata['info']['participants'][i]['summonerName']: {}})  # create a hashmap entry for player i

            # fill out the hashmap with stats of player i
            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['matchId'] = match_id

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['gameDuration'] = \
                game_length_minutes_and_seconds

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['championName'] = \
                match_metadata['info']['participants'][i]['championName']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['kills'] = \
                match_metadata['info']['participants'][i]['kills']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['deaths'] = \
                match_metadata['info']['participants'][i]['deaths']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['assists'] = \
                match_metadata['info']['participants'][i]['assists']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['firstBloodKill'] = \
                match_metadata['info']['participants'][i]['firstBloodKill']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['goldEarned'] = \
                match_metadata['info']['participants'][i]['goldEarned']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['pentaKills'] = \
                match_metadata['info']['participants'][i]['pentaKills']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['timeCCingOthers'] = \
                match_metadata['info']['participants'][i]['timeCCingOthers']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalTimeCCDealt'] = \
                match_metadata['info']['participants'][i]['totalTimeCCDealt']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalDamageDealtToChampions'] = \
                match_metadata['info']['participants'][i]['totalDamageDealtToChampions']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['totalMinionsKilled'] = \
                match_metadata['info']['participants'][i]['totalMinionsKilled']

            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['visionScore'] = \
                match_metadata['info']['participants'][i]['visionScore']

        APIToMySQL.insert_to_match_statistics_table(match_statistics)  # attempting to write match stats to DB

    except HTTPError as error_message:
        print(f"Match id {match_id} not found: " + str(error_message))


api_key = getapikey()

my_region = 'eun1'
name = 'Ego the 1st'

lol_watcher = riotwatcher.LolWatcher(api_key, default_status_v4=True)

region_input = sys.argv[1]
match_id_input = sys.argv[2]

get_match_info_by_match_id(lol_watcher, region_input, match_id_input)  # getting match statistics
