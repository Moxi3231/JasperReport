/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myutils;

import com.POJO.StudentRc;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bson.Document;

/**
 *
 * @author moxan
 */
public class Retriever {
    MongoConnection mcon;
    public List<StudentRc> getStudentList(String uname)
    {
        mcon = new MongoConnection();
        MongoCursor<Document> mcr = mcon.getMongoCursor();
        List<StudentRc> lsr = new ArrayList<StudentRc>();
        while(mcr.hasNext())
        {
            Document row  = mcr.next();
            if(row.getString("University Name").equals(uname) || uname.equals("__ALL__"))
                lsr.add(new StudentRc(row.getString("First Name"),Float.parseFloat(row.get("DegreePercentage").toString()),row.getString("University Name")));
        }
        return lsr;
    }
    public Set<String> getUniversityList()
    {
        mcon = new MongoConnection();
        MongoCursor<Document> mcr = mcon.getMongoCursor();
        Set<String> stu = new HashSet<String>();
        while(mcr.hasNext())
        {
            Document row  = mcr.next();
            stu.add(row.getString("University Name"));
        }
        return stu;
    }
}
