import csv
import pymysql

 
filename = 'Mobile_Food_Facility_Permit.csv'

            # locationid0,  Applicant1,   FacilityType2,   cnn3,    LocationDescription4,    Address5,
            # blocklot6,     block7,          lot8,
            # permit9,   Status10,    FoodItems11,  X12,  Y13 ,     Latitude14,       Longitude15,      Schedule16,
            # dayshours17,    NOISent18,    Approved19,   Received20,       PriorPermit21,
            # ExpirationDate22,       Location23,       Fire Prevention Districts24,
            # Police Districts25,         Supervisor Districts26,       Zip Codes27,      Neighborhoods (old)28
def write_location(connection, row ):
    with connection.cursor() as cursor:
        sql = ("INSERT INTO `tb_location_info` (`locationid`, `x`, `y`, `latitude`, "
        "`longitude`,`address`,`location_description`,`zipcode`,"
        "`fire_prevention_districts`,`police_districts`,`supervisor_districts`,`neighborhoods_old`, "
        "`blocklot`, `block` , `lot`, `location`) " 
        "VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s)"  )
         
        data_to_insert = [  
            (row[0], row[12], row[13],row[14],
             row[15], row[5], row[4],row[27],
             row[24], row[25], row[26],row[28],
             row[6] ,row[7], row[8], row[23]),  
        ]  
          
        
        cursor.executemany(sql, data_to_insert)  
          
  
        connection.commit()  

def write_applicat(connection, row ):
    with connection.cursor() as cursor:  
            # locationid0,  Applicant1,   FacilityType2,   cnn3,    LocationDescription4,    Address5,
            # blocklot6,     block7,          lot8,
            # permit9,   Status10,    FoodItems11,  X12,  Y13 ,     Latitude14,       Longitude15,      Schedule16,
            # dayshours17,    NOISent18,    Approved19,   Received20,       PriorPermit21,
            # ExpirationDate22,       Location23,       Fire Prevention Districts24,
            # Police Districts25,         Supervisor Districts26,       Zip Codes27,      Neighborhoods (old)28
        sql = ("INSERT INTO `tb_applicant_info` (`applicant_name`, `locationid`, `facility_type`, `food_items`,`days_hours`, `cnn`,`schedule`) "
        "VALUES (%s, %s, %s, %s, %s, %s, %s)")  
          

        data_to_insert = [  
            (row[1], row[0], row[2],row[11],row[17],row[3],row[16]),  
        ]  
          

        cursor.executemany(sql, data_to_insert)  
          
        connection.commit()  

def write_permit(connection, row ):
    with connection.cursor() as cursor:  
            # locationid0,  Applicant1,   FacilityType2,   cnn3,    LocationDescription4,    Address5,
            # blocklot6,     block7,          lot8,
            # permit9,   Status10,    FoodItems11,  X12,  Y13 ,     Latitude14,       Longitude15,      Schedule16,
            # dayshours17,    NOISent18,    Approved19,   Received20,       PriorPermit21,
            # ExpirationDate22,       Location23,       Fire Prevention Districts24,
            # Police Districts25,         Supervisor Districts26,       Zip Codes27,      Neighborhoods (old)28
       
        sql = ("INSERT INTO `tb_permit_info` (`permit`, `locationid`, `prior_permit`, `expiration_date`, "
            "`status`,`approved_date`,`received_date`,`nio_sent`) "
        "VALUES (%s, %s, %s, %s, %s, %s, %s, %s)" ) 
          
        data_to_insert = [  
            (row[9],row[0],row[21],row[22],row[10],row[19],row[20],row[18]),  
        ]  
          
        cursor.executemany(sql, data_to_insert)  
        
        connection.commit()  



conn = pymysql.connect(host='localhost', user='demo', password='demo', database='demo', port=3306)

try:
    with open(filename, 'r', encoding='utf-8') as file:
        reader = csv.reader(file)
        for index, row in enumerate(reader):  
            if index == 0:
                continue
            for i, r in enumerate(row):
                if len(r) == 0:
                    row[i] = " "
            write_location(conn, row)
            write_applicat(conn, row)
            write_permit(conn, row)
            print(row)
finally:  
    conn.close()

