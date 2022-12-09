import mysql.connector
from mysql.connector.constants import ClientFlag


class config:
    def getconfig(self):
        cnx = mysql.connector.connect(host="localhost",
                                      user="",
                                      password="",
                                      database="",
                                      port = '',)
        return cnx

    def getapikey(self):
        api_key = ''
        return api_key
