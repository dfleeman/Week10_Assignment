package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Bike;


public class CycleDao {
	private Connection connection;
	private final String SHOW_ALL_BIKES_QUERY = "SELECT * FROM bikes";
	private final String DELETE_BIKES_BY_ID_QUERY = "DELETE FROM bikes WHERE id = ?";
	private final String CREATE_NEW_BIKE_QUERY = "INSERT INTO bikes(year, make, model, engine_size) VALUES (?,?,?,?)";
	private final String UPDATE_BIKE_BY_ID_QUERY = "UPDATE bikes SET year = ?, make = ?, model = ?, engine_size = ? WHERE id = ?";

	public CycleDao() {
		connection = DBConnection.getConnection();
	}

	public List<Bike> getBikes() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(SHOW_ALL_BIKES_QUERY);
		ResultSet rs = ps.executeQuery();
		List<Bike> bikes = new ArrayList<Bike>();

		while (rs.next()) {
			bikes.add(populateBike(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
		}
		return bikes;
	}


	public void createNewBike(int year, String make, String model, int engineSize) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_BIKE_QUERY);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setInt(4, engineSize);
		ps.executeUpdate();
	}

	public void updateBikeById(int id, int year, String make, String model, int engineSize) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_BIKE_BY_ID_QUERY);
		ps.setInt(1, year);
		ps.setString(2, make);
		ps.setString(3, model);
		ps.setInt(4, engineSize);
		ps.setInt(5, id);
		ps.executeUpdate();
	}

	public void deleteBikeById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_BIKES_BY_ID_QUERY);
		ps.setInt(1, id);
		ps.executeUpdate();

	}

	private Bike populateBike(int id, int year, String make, String model, int engine_size) throws SQLException {
		return new Bike(id, year, make, model, engine_size);
	}

}
