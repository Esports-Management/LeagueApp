import mysql.connector
from mysql.connector.constants import ClientFlag


class config:
    def getconfig(self):
        cnx = mysql.connector.connect(host="localhost",
                                      user="root",
                                      password="admin123",
                                      database="EsportsApp",
                                      port = '8889',)
        return cnx

    def getapikey(self):
        api_key = 'RGAPI-7706a968-6aca-4fd4-af95-bb3e4aef04fc'
        return api_key
