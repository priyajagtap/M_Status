package com.primol.m_status;

/**
 * Created by infogird31 on 21/10/2016.
 */
public class id_name_model {
    int id;
    String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public id_name_model(int id, String status) {
        this.id = id;
        this.status = status;
    }
    public id_name_model(String status) {
        this.status = status;
    }
}

  //  CREATE TABLE `Marathi_Status` ( `id` INTEGER PRIMARY KEY AUTOINCREMENT, `status` TEXT )

//CREATE TABLE "marathi_status" ("cat_id" INTEGER, "status_id" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL , "status" VARCHAR)

//INSERT INTO Marathi_Status(status) SELECT status FROM sms.marathi_status;

//
// DELETE FROM Marathi_Status WHERE id NOT IN(SELECT MIN(id) FROM Marathi_StatusGROUP BY status);