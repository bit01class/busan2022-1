package com.bit.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;



public class EmpDao {
	String addr="localhost:27017";
	MongoClient client=null;

	public void insertOne(Map<String,String[]> items) {
		
		try {
			client=new MongoClient(addr);
			MongoDatabase db = client.getDatabase("testDB");
			MongoCollection<Document> coll = db.getCollection("emp");
			Document doc=new Document();
			Set<Entry<String, String[]>> entrys = items.entrySet();
			Iterator<Entry<String, String[]>> ite = entrys.iterator();
			while(ite.hasNext()) {
				Entry<String, String[]> entry=ite.next();
				if(entry.getKey().equals("item"))
					doc.append(entry.getKey(), Arrays.asList(entry.getValue()));
				else
					doc.append(entry.getKey(), entry.getValue()[0]);
			}
			coll.insertOne(doc);
		}finally {
			if(client!=null)client.close();
		}
	}
	
//	public List<Map<String,Object>> selectAll(){
//		List<Map<String,Object>> list=new ArrayList<>();
//		try {
//			client=new MongoClient(addr);
//			MongoDatabase db=client.getDatabase("testDB");
//			MongoCollection<Document> rs=db.getCollection("emp");
//			MongoCursor<Document> cur=rs.find().iterator();
//			while(cur.hasNext()) {
//				Map<String,Object> bean=new HashMap<String,Object>();
//				Document doc=cur.next();
//				bean.put("_id",doc.get("_id"));
//				bean.put("empno",doc.get("empno"));
//				bean.put("ename",doc.get("ename"));
//				list.add(bean);
//			}
//		}finally {
//			if(client!=null)client.close();
//		}
//		
//		return list;
//	}
	public List<EmpDto> selectAll(){
		List<EmpDto> list=new ArrayList<>();
		try {
			client=new MongoClient(addr);
			MongoDatabase db=client.getDatabase("testDB");
			MongoCollection<Document> rs=db.getCollection("emp");
			MongoCursor<Document> cur=rs.find().iterator();
			while(cur.hasNext()) {
				EmpDto bean=new EmpDto();
				Document doc=cur.next();
				bean.setId(doc.getObjectId("_id"));
				bean.setEmpno(Integer.parseInt(doc.get("empno").toString()));
				bean.setEname(doc.getString("ename"));
				bean.setItem(doc.getList("item", String.class));
				list.add(bean);
			}
		}finally {
			if(client!=null)client.close();
		}
		
		return list;
	}
	
	public EmpDto selectOne(String idx) {
		// {_id:ObjectId('628729eb82344039e4f4403e')}
		try {
			client=new MongoClient(addr);
			MongoDatabase db=client.getDatabase("testDB");
			MongoCollection<Document> coll = db.getCollection("emp");
			
			Bson filter=BsonDocument.parse("{_id:ObjectId('628729eb82344039e4f4403e')}");
//			Bson filter=Filters.eq("_id", new ObjectId(idx));
//			Bson filter=new BasicDBObject("_id",new ObjectId(idx));
			Document doc = coll.find(filter).first();
//			return doc.toJson();
			EmpDto bean=new EmpDto();
			bean.setId(doc.getObjectId("_id"));
			bean.setEmpno(Integer.parseInt(doc.get("empno").toString()));
//			bean.setEmpno(doc.getInteger("empno",0));
			bean.setEname(doc.getString("ename"));
			bean.setItem(doc.getList("item", String.class));
			return bean;
		}finally {
			if(client!=null)client.close();
		}
	}
	
	public void updateOne(Map<String,String[]> params) {
		try(MongoClient client=new MongoClient(new ServerAddress("localhost", 27017))){
			MongoDatabase db = client.getDatabase("testDB");
			MongoCollection<Document> coll = db.getCollection("emp");
			
			
			Bson filter=new BasicDBObject("_id",new ObjectId(params.get("_id")[0]));
//			String [] arr=params.get("item");
//			String item="";
//			for(int i=0; i<arr.length; i++) {
//				if(i!=0)item+=',';
//				item+="'"+arr[i]+"'";
//			}
//			Bson update=BsonDocument.parse("{$set:{empno:"
//						+params.get("empno")[0]+",ename:'"+params.get("ename")[0]+"',item:["+item+"]}}");
			
			BasicDBObject update2=new BasicDBObject();
			BasicDBObject update3=new BasicDBObject();
			update3.append("empno", params.get("empno")[0]);
			update3.append("ename", params.get("ename")[0]);
			update3.append("item", params.get("item"));
			update2.append("$set", update3);
			
			coll.updateOne(filter, update2);
		}
	}
}














