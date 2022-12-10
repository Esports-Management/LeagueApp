import mysql.connector
from src.main.Python.Conf.config import config


def insert_to_match_statistics_table(match_statistics):
    # cnx = mysql.connector.connect(host="localhost",
    #                              user="root",
    #                            password="",
    #                            database="users_db")
    cnx = config().getconfig()

    mycursor = cnx.cursor()
    table_found = False
    mycursor.execute("""
        SELECT COUNT(*)
        FROM information_schema.tables
        WHERE table_name = 'match_statistics'""")
    if mycursor.fetchone()[0] == 1:
        table_found = True

    if not table_found:
<<<<<<< HEAD
      mycursor.execute("CREATE TABLE match_statistics "
                       "(summonerName VARCHAR(255), matchID VARCHAR(255), "
                       "gameDuration VARCHAR(12), championName VARCHAR(30), "
                       "kills INT(3), deaths INT(3), assists INT(3), "
                       "firstBloodKill BOOLEAN, goldEarned INT(10), "
                       "pentaKills INT(2), timeCCingOthers INT(3), "
                       "totalTimeCCDealt INT(10), totalDamageDealtToChampions INT(20), "
                       "totalMinionsKilled INT(10), visionScore INT(5))")
=======
        mycursor.execute("CREATE TABLE match_statistics "
                         "(summonerName VARCHAR(255), matchID VARCHAR(255), "
                         "kills INT(3), deaths INT(3), assists INT(3), "
                         "firstBloodKill BOOLEAN, goldEarned INT(10), "
                         "pentaKills INT(2), timeCCingOthers INT(3), "
                         "totalTimeCCDealt INT(10), totalDamageDealtToChampions INT(20), "
                         "totalMinionsKilled INT(10), visionScore INT(5))")
>>>>>>> ffb645de03e0f8f5c960a111f3e97f0a4ac5296a

    query = ("INSERT INTO match_statistics "
             "(summonerName, matchID, gameDuration, championName, "
             "kills, deaths, assists, firstBloodKill, goldEarned, "
             "pentaKills, timeCCingOthers, totalTimeCCDealt, totalDamageDealtToChampions, "
             "totalMinionsKilled, visionScore) "
             "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)")

    for summoner in match_statistics:

<<<<<<< HEAD
        mycursor.execute(
            "SELECT summonerName, matchID, COUNT(*) "
            "FROM match_statistics "
            "WHERE summonerName = %s AND matchID = %s"
            "GROUP BY summonerName", (summoner, match_statistics[summoner]['matchId'],)
        )
        results = mycursor.fetchall()
        row_count = mycursor.rowcount

        if row_count == 0: # add row if row with this matchId and summonerName doesn't exist

            val = (
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
=======
        mycursor.execute(query, val)
        cnx.commit()

    mycursor.close()
>>>>>>> ffb645de03e0f8f5c960a111f3e97f0a4ac5296a
