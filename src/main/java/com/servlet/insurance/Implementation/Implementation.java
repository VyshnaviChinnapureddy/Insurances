package com.servlet.insurance.Implementation;

import java.sql.Connection;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.servlet.encapsulatedclass.ClaimEntity;
import com.servlet.encapsulatedclass.EnrollmentEntity;
import com.servlet.encapsulatedclass.LoansEntity;
import com.servlet.encapsulatedclass.PolicyEntity;
import com.servlet.jdbc.Jdbc;

public class Implementation {

	Connection con;
    PreparedStatement prep;
    ResultSet resultset;
    
	public Implementation() {
		con=Jdbc.getinstance();
	}
	
	public int Enrollment(EnrollmentEntity entity) throws SQLException {
		int result=0;
		//System.out.println("method triggered in enrollment");
		String query="insert into enrollment values(?,?,?,?,?,?,?)";
		prep=con.prepareStatement(query);
	
		prep.setString(1,entity.getFirstname());
		prep.setString(2,entity.getLastname());
		prep.setString(3,entity.getDateofBirth());
		prep.setString(4,entity.getGmailid());
		prep.setString(5, entity.getMobilenumber());
		prep.setString(6,entity.getAddress());
		prep.setString(7,entity.getPolicyname());
		result=prep.executeUpdate();
		return result;
	}
	
	//joins
	
	public Map<EnrollmentEntity,Map<PolicyEntity,ClaimEntity>>Joins() throws SQLException{
		Map<EnrollmentEntity, Map<PolicyEntity,ClaimEntity>> m1=new HashMap<EnrollmentEntity, Map<PolicyEntity,ClaimEntity>>();
		System.out.println("Join method Triggered");
		String query= "select* from enrollment e left join policy p on e.policyname=p.policyname left join claimstatus s on e.policyname=s.policyname";
		prep=con.prepareStatement(query);
		resultset=prep.executeQuery();
		
		while(resultset.next()) {
			PolicyEntity p=new PolicyEntity();
			EnrollmentEntity e= new EnrollmentEntity();
			ClaimEntity c=new ClaimEntity();
			e.setFirstname(resultset.getString("firstname"));
			e.setLastname(resultset.getString("lastname"));
			e.setDateofBirth(resultset.getString("DateofBirth"));
			e.setGmailid(resultset.getString("gmailid"));
			e.setMobilenumber(resultset.getString("mobilenumber"));
			e.setAddress(resultset.getString("address"));
			e.setPolicyname(resultset.getString("policyname"));
			p.setPolicyid(resultset.getString("policyid"));
			p.setPolicyname(resultset.getString("policyname"));
			p.setPremiumrange(resultset.getString("premiumrange"));
			p.setClaim(resultset.getString("Claim"));
			p.setEntryage(resultset.getString("Entryage"));
			p.setEndage(resultset.getString("Endage"));
			c.setClientname(resultset.getString("clientname"));
			c.setPolicyname(resultset.getString("policyname"));
			c.setDatecreated(resultset.getString("datecreated"));
			c.setStatus(resultset.getString("status"));
			//m1.get(p).put(e, c);
			
			 if (!m1.containsKey(p)) {
		            // If not, create a new inner map and put it into the outer map
		            m1.put(e, new HashMap<>());
		        }
		        
		        // Put the EnrollmentEntity object e and ClaimEntity object c into the inner map associated with p
		        m1.get(e).put(p, c);
		    }
		
		
		return m1;
	}
	// View policy table
	public List<PolicyEntity>Fetch() throws SQLException{
		List<PolicyEntity> l= new ArrayList<PolicyEntity>();
		System.out.println("Fetch triggered");
		String query="select* from policy";
		PolicyEntity entity=null;
		prep=con.prepareStatement(query);
		resultset=prep.executeQuery();
		while(resultset.next()) {
			entity=new PolicyEntity();
			
			entity.setPolicyid(resultset.getString(1));
			entity.setPolicyname(resultset.getString(2));
			entity.setPremiumrange(resultset.getString(3));
			entity.setClaim(resultset.getString(4));
			entity.setEntryage(resultset.getString(5));
			entity.setEndage(resultset.getString(6));
			l.add(entity);
		}
		return l;
	}
	// View claim table
	public List<ClaimEntity>Fetch1() throws SQLException{
		List<ClaimEntity> l= new ArrayList<ClaimEntity>();
		System.out.println("Fetch triggered");
		String query="select* from claimstatus";
		ClaimEntity entity=null;
		prep=con.prepareStatement(query);
		resultset=prep.executeQuery();
		while(resultset.next()) {
			entity=new ClaimEntity();
			entity.setClientname(resultset.getString(1));
			entity.setPolicyname(resultset.getString(2));
			entity.setDatecreated(resultset.getString(3));
			entity.setStatus(resultset.getString(4));
			l.add(entity);
		}
		return l;
	}
	public Map<EnrollmentEntity, Map<PolicyEntity, Map<ClaimEntity,LoansEntity>>>profile() throws SQLException{
			Map<EnrollmentEntity, Map<PolicyEntity,Map<ClaimEntity,LoansEntity>>> m1=new HashMap<EnrollmentEntity, Map<PolicyEntity,Map<ClaimEntity,LoansEntity>>>();
			System.out.println("Joining method Triggered");
			String query1= "select* from enrollment e left join policy p on e.policyname=p.policyname left join claimstatus s on e.policyname=s.policyname left join loans l on e.policyname=l.policyname";
			try {
			    prep = con.prepareStatement(query1);
			    resultset = prep.executeQuery();
			} catch (SQLException e) {
			    e.printStackTrace();
			}
			
			
			while(resultset.next()) {
				PolicyEntity p=new PolicyEntity();
				EnrollmentEntity e= new EnrollmentEntity();
				ClaimEntity c=new ClaimEntity();
				LoansEntity l1=new LoansEntity();
				e.setFirstname(resultset.getString("firstname"));
				e.setLastname(resultset.getString("lastname"));
				e.setDateofBirth(resultset.getString("DateofBirth"));
				e.setGmailid(resultset.getString("gmailid"));
				e.setMobilenumber(resultset.getString("mobilenumber"));
				e.setAddress(resultset.getString("address"));
				e.setPolicyname(resultset.getString("policyname"));
				
				p.setPolicyid(resultset.getString("policyid"));
				p.setPolicyname(resultset.getString("policyname"));
				p.setPremiumrange(resultset.getString("premiumrange"));
				p.setClaim(resultset.getString("Claim"));
				p.setEntryage(resultset.getString("Entryage"));
				p.setEndage(resultset.getString("Endage"));
				
				c.setClientname(resultset.getString("clientname"));
				c.setPolicyname(resultset.getString("policyname"));
				c.setDatecreated(resultset.getString("datecreated"));
				c.setStatus(resultset.getString("status"));
				
				l1.setPolicyname(resultset.getString("policyname"));
				l1.setTypeofloan(resultset.getString("typeofloan"));
				l1.setAmountsecured(resultset.getString("amountsecured"));
				l1.setIntrest(resultset.getString("intrest"));
				l1.setAge(resultset.getString("age"));
				 m1.putIfAbsent(e, new HashMap<>());
				 System.out.println("e: " + e);
				 System.out.println("p: " + p);
				 System.out.println("c: " + c);
				 System.out.println("l1: " + l1);
				 
				 if (!m1.containsKey(e)) {
					    // If not, create a new inner map and put it into the outer map
					    m1.put(e, new HashMap<>());
					}

					// Check if the inner map associated with 'e' contains the key 'p'
					if (!m1.get(e).containsKey(p)) {
					    // If not, create a new inner map and put it into the outer map
					    m1.get(e).put(p, new HashMap<>());
					}

					// Now, put the value 'l1' into the innermost map associated with 'e' and 'p'
					m1.get(e).get(p).put(c, l1);
				// if (e != null && p != null && c != null && l1 != null) {
					    // Proceed with putting values into the nested map
				//	} else {
					    // Handle null values
				//	}
				 //   m1.get(e).putIfAbsent(p, new HashMap<>());

				    // Put values into the nested map
				   // m1.get(e).get(p).put(c, l1);
			//	m1.computeIfAbsent(e, k -> new HashMap<PolicyEntity, Map<ClaimEntity, LoansEntity>>())
				//   .computeIfAbsent(p, k -> new HashMap<ClaimEntity, LoansEntity>()).put(c, l1);
				  
			
				
			}
			
			return m1;
		
	}
	
	public Map<EnrollmentEntity,Map<PolicyEntity,LoansEntity>>Joining() throws SQLException{
		Map<EnrollmentEntity, Map<PolicyEntity,LoansEntity>> m1=new HashMap<EnrollmentEntity, Map<PolicyEntity,LoansEntity>>();
		System.out.println("Join method Triggered");
		String query="select* from enrollment e left join policy p on e.policyname=p.policyname left join loans l on e.policyname=l.policyname";
		prep=con.prepareStatement(query);
		resultset=prep.executeQuery();
		
		while(resultset.next()) {
			PolicyEntity p=new PolicyEntity();
			EnrollmentEntity e= new EnrollmentEntity();
			LoansEntity l=new LoansEntity();
			e.setFirstname(resultset.getString("firstname"));
			e.setLastname(resultset.getString("lastname"));
			e.setDateofBirth(resultset.getString("DateofBirth"));
			e.setGmailid(resultset.getString("gmailid"));
			e.setMobilenumber(resultset.getString("mobilenumber"));
			e.setAddress(resultset.getString("address"));
			e.setPolicyname(resultset.getString("policyname"));
			
			p.setPolicyid(resultset.getString("policyid"));
			p.setPolicyname(resultset.getString("policyname"));
			p.setPremiumrange(resultset.getString("premiumrange"));
			p.setClaim(resultset.getString("Claim"));
			p.setEntryage(resultset.getString("Entryage"));
			p.setEndage(resultset.getString("Endage"));
			
			l.setPolicyname(resultset.getString("policyname"));
			l.setTypeofloan(resultset.getString("typeofloan"));
			l.setAmountsecured(resultset.getString("amountsecured"));
			l.setIntrest(resultset.getString("intrest"));
			l.setAge(resultset.getString("age"));
			
			//m1.get(p).put(e, c);
			
			 if (!m1.containsKey(p)) {
		            // If not, create a new inner map and put it into the outer map
		            m1.put(e, new HashMap<>());
		        }
		        
		        // Put the EnrollmentEntity object e and ClaimEntity object c into the inner map associated with p
		        m1.get(e).put(p, l);
		    }
		
		
		return m1;
	}
	
}
