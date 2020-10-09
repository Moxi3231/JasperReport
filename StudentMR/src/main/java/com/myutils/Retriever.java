/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myutils;

import com.POJO.StudentRc;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.AggregateIterable;
import static com.mongodb.client.model.Aggregates.group;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javafx.animation.KeyValue;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * @author moxan
 */
public class Retriever {

    MongoConnection mcon;

    public List<StudentRc> getStudentList(String bck) {
        mcon = new MongoConnection();
        MongoCollection<Document> mcol = mcon.getMongoCollection();
        List<StudentRc> lsr = new ArrayList<StudentRc>();
        
        MongoCursor<Document> mcr = mcol.find().iterator();

        Set<String> unlist = getUniversityList();
        HashMap<String, List<Double>> avpercentage = new HashMap<String, List<Double>>();
        HashMap<String, String> backuni = new HashMap<String, String>();
        while (mcr.hasNext()) {
            Document row = mcr.next();
            if (!row.getString("Background(CS\\NCS)").equals(bck) && !bck.equals("__ALL__")) {
                continue;
            }
            String uname = row.getString("University Name");
            if (!avpercentage.containsKey(uname)) {
                avpercentage.put(uname, new ArrayList<Double>());
                backuni.put(uname, row.getString("Background(CS\\NCS)"));
            }
            avpercentage.get(uname).add(Double.parseDouble(row.get("DegreePercentage").toString()));
        }
        Iterator<Entry<String, String>> bguin = backuni.entrySet().iterator();
        while (bguin.hasNext()) {
            Entry<String, String> temp = bguin.next();
            Double avpr = 0.0;
            avpr = avpercentage.get(temp.getKey()).stream().map(pr -> pr).reduce(avpr, (accumulator, _item) -> accumulator + _item);
            avpr = avpr / avpercentage.get(temp.getKey()).size();
            lsr.add(new StudentRc(avpr, temp.getKey(), temp.getValue()));
        }
        mcon.mongoc.close();
        return lsr;
    }

    public Set<String> getUniversityList() {
        mcon = new MongoConnection();
        MongoCursor<Document> mcr = mcon.getMongoCollection().find().iterator();
        Set<String> stu = new HashSet<String>();
        while (mcr.hasNext()) {
            Document row = mcr.next();
            stu.add(row.getString("University Name"));
        }
        mcon.mongoc.close();
        return stu;
    }
}
