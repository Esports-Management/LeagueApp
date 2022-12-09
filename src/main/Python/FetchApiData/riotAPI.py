import riotwatcher
from datetime import datetime
import pprint
import APIToMySQL
from src.main.Python.Conf.config import config


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

    def get_match_info_by_match_id(self, lol_watcher, region, match_id):
        match_metadata = lol_watcher.match.by_id(region, match_id)

        match_statistics = {}

        for i in range(len(match_metadata['info']['participants'])):
            match_statistics.update({match_metadata['info']['participants'][i]['summonerName']: {}})
            match_statistics[match_metadata['info']['participants'][i]['summonerName']]['matchId'] = match_id
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

<<<<<<< HEAD
api_key = 'RGAPI-ecfce8dc-2400-4781-92b8-33959ee82433'
=======

api_key = config().getapikey()
>>>>>>> feature/configcreatepython
my_region = 'eun1'
name = 'Ego the 1st'

lol_watcher = riotwatcher.LolWatcher(api_key, default_status_v4=True)

summoner = lol_watcher.summoner.by_name(my_region, name)

summoner_1 = Summoner(summoner)
summoner_1.get_match_list(lol_watcher, my_region)
summoner_1.get_league_info(lol_watcher, my_region)

summoner_1.get_challenger_by_queue_ranked_solo_5x5(lol_watcher, my_region)
summoner_1.get_challenger_by_queue_ranked_flex_sr(lol_watcher, my_region)

match_id = 'EUN1_3257332892'

match_info = summoner_1.get_match_info_by_match_id(lol_watcher, my_region, match_id)
pprint.pprint(match_info)
match_info = summoner_1.get_match_info_by_match_id(lol_watcher, my_region, 'EUN1_3257332892')
pprint.pprint(match_info)
