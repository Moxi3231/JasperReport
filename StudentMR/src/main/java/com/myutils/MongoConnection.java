/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myutils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author moxan
 */
public class MongoConnection {

    MongoClient mongoc;

    public MongoCollection<Document> getMongoCollection() {
        mongoc = new MongoClient("localhost", 27017);
        return mongoc.getDatabase("BDA").getCollection("student_master");
    }
}
