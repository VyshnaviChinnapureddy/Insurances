package com.servlet.insurance.Implementation;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.servlet.encapsulatedclass.Insuranceentity;
import com.servlet.jdbc.Jdbc;

public class InsuranceImplementation {

	Connection con;
	PreparedStatement prep;
	ResultSet resultset;
	Statement state;

	public InsuranceImplementation() {
		con=Jdbc.getinstance();
	}

	//Add policydetails into Insurancedetails table
	public int AddPolicydetails(Insuranceentity entity) {
		int result=0;
		System.out.println("method triggered in enrollment");
		String query="insert into insurancedetails values(?,?,?,?,?,?,?)";

		try {
			prep=con.prepareStatement(query);

			prep.setString(1,entity.getPolicycode());
			prep.setString(2,entity.getPolicyname());
			prep.setString(3,entity.getPolicytype());
			prep.setString(4,entity.getPolicysubtype());
			prep.setString(5,entity.getAnnualpremiumrange());
			prep.setString(6,entity.getEligiblityage());
			prep.setString(7,entity.getKeybenefits());
			result=prep.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	//update
	public int update(Insuranceentity entity) {
		int result=0;
		String query="update insurancedetails set annualpremiumrange = ?, eligiblityage = ?,keybenefits = ? where policycode = ?";
		try {
			prep=con.prepareStatement(query);
			prep.setString(1, entity.getAnnualpremiumrange());
			prep.setString(2, entity.getEligiblityage());
			prep.setString(3, entity.getKeybenefits());
			prep.setString(4, entity.getPolicycode());
			result=prep.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	//Viewing all Insurances
		public List<Insuranceentity> fetch(String policytype) {
			List<Insuranceentity> listinsurance = new ArrayList<>();
			System.out.println("Fetch data triggered");
			String query = "SELECT * FROM insurancedetails where policytype = ? ";

			Insuranceentity entity = null;
			try {
				PreparedStatement preparedStatement = con.prepareStatement(query);
				preparedStatement.setString(1, policytype);
				ResultSet resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					entity = new Insuranceentity();
					entity.setPolicycode(resultSet.getString(1));
					entity.setPolicyname(resultSet.getString(2));
					entity.setPolicytype(resultSet.getString(3));
					entity.setPolicysubtype(resultSet.getString(4));
					entity.setAnnualpremiumrange(resultSet.getString(5));
					entity.setEligiblityage(resultSet.getString(6));
					entity.setKeybenefits(resultSet.getString(7));
					listinsurance.add(entity);
				}
				//resultSet.close();
				//  preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return listinsurance;
		}

	//Delete Data from DB
	public int delete(Insuranceentity entity) {
		int result =0;
		String query = "Delete from insurancedetails where policycode = '"+entity.getPolicycode()+"';";
		//String query = " delete from mercedes where Modelname = ?";
		// prep.SetString(1,entity.getModelname());
		//result = prep.executeUpdate();

		try {
			state = con.createStatement();
			result = state.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	// Sorting method Insurances
	public List<Insuranceentity> sort(String policyType, String sortBy) {
		List<Insuranceentity> listinsurance = new ArrayList<>();
		System.out.println("Fetch data triggered");
		String query = "select * from insurancedetails where policytype = ? order by eligiblityage asc; ";
		System.out.println(query);


		Insuranceentity entity = null;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, policyType);
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				entity = new Insuranceentity();
				entity.setPolicycode(resultSet.getString(1));
				entity.setPolicyname(resultSet.getString(2));
				entity.setPolicytype(resultSet.getString(3));
				entity.setPolicysubtype(resultSet.getString(4));
				entity.setAnnualpremiumrange(resultSet.getString(5));
				entity.setEligiblityage(resultSet.getString(6));
				entity.setKeybenefits(resultSet.getString(7));
				listinsurance.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listinsurance;
	}

}