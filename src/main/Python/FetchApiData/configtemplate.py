import mysql.connector
from mysql.connector.constants import ClientFlag


def getapikey():
    api_key = 'RGAPI-9d25c1b9-0261-47b9-a248-66de594c6ac6'
    return api_key


def getconfig():
    cnx = mysql.connector.connect(host="localhost",
                                  user="root",
                                  password="",
                                  database="EsportsApp",
                                  port = '3306',)
    return cnx