from config import getconfig


def insert_to_match_statistics_table(match_statistics):
    # cnx = mysql.connector.connect(host="localhost",
    #                              user="root",
    #                            password="",
    #                            database="users_db")
    cnx = getconfig()

    mycursor = cnx.cursor()
    table_found = False
    mycursor.execute("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_name = 'match_statistics'""")
    if mycursor.fetchone()[0] == 1:
        table_found = True

    if not table_found:

      mycursor.execute("CREATE TABLE match_statistics "
                       "(id BIGINT(20) AUTO_INCREMENT PRIMARY KEY, summoner_name VARCHAR(255), match_id VARCHAR(255), "
                       "game_duration VARCHAR(12), champion_name VARCHAR(30), "
                       "kills INT(3), deaths INT(3), assists INT(3), "
                       "first_blood_kill BOOLEAN, gold_earned INT(10), "
                       "penta_kills INT(2), time_ccing_others INT(3), "
                       "total_time_cc_dealt INT(10), total_damage_dealt_to_champions INT(20), "
                       "total_minions_killed INT(10), vision_score INT(5))")

    query = ("INSERT INTO match_statistics "
             "(id, summoner_name, match_id, game_duration, champion_name, "
             "kills, deaths, assists, first_blood_kill, gold_earned, "
             "penta_kills, time_ccing_others, total_time_cc_dealt, total_damage_dealt_to_champions, "
             "total_minions_killed, vision_score) "
             "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)")

    for summoner in match_statistics:
        mycursor.execute("SELECT * FROM match_statistics ")
        results = mycursor.fetchall()
        last_row_id = mycursor.rowcount

        mycursor.execute(
            "SELECT summoner_name, match_id, COUNT(*) "
            "FROM match_statistics "
            "WHERE summoner_name = %s AND match_id = %s"
            "GROUP BY summoner_name", (summoner, match_statistics[summoner]['matchId'],)
        )
        results = mycursor.fetchall()
        row_count = mycursor.rowcount

        if row_count == 0: # add row if row with this matchId and summonerName doesn't exist

            val = (
                last_row_id,
                summoner,
                match_statistics[summoner]['matchId'],
                match_statistics[summoner]['gameDuration'],
                match_statistics[summoner]['championName'],
                match_statistics[summoner]['kills'],
                match_statistics[summoner]['deaths'],
                match_statistics[summoner]['assists'],
                match_statistics[summoner]['firstBloodKill'],
                match_statistics[summoner]['goldEarned'],
                match_statistics[summoner]['pentaKills'],
                match_statistics[summoner]['timeCCingOthers'],
                match_statistics[summoner]['totalTimeCCDealt'],
                match_statistics[summoner]['totalDamageDealtToChampions'],
                match_statistics[summoner]['totalMinionsKilled'],
                match_statistics[summoner]['visionScore']
            )

            mycursor.execute(query, val)
            cnx.commit()

    mycursor.close()
