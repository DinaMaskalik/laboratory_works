package bsuir;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(eager = true)
@ApplicationScoped
public class SportClubBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String url = "jdbc:mysql://localhost:3306/lab5";
	private final String user = "root";
	private final String password = "root";

	private String searchBySection;

	private String deleteBySection;

	private SportClub resultOfSearch;

	private String section;

	private String FIO;

	private double price;

	private List<SportClub> sportClubs;

	@PostConstruct
	private void inizialize() {
		try {
			sportClubs = new ArrayList<SportClub>();
			Statement statement = DriverManager.getConnection(url, user, password).createStatement();
			String query = "SELECT * FROM sportclub";
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				sportClubs.add(new SportClub(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3))));
			}
			statement.close();
		}catch (Throwable e){
			e.printStackTrace();
		}
	}

	public void search() throws SQLException {
		Statement statement = DriverManager.getConnection(url, user, password).createStatement();
		String query = "SELECT * FROM sportclub WHERE sections='" + searchBySection + "';";
		ResultSet rs = statement.executeQuery(query);

		if (rs.next()) {
			resultOfSearch = new SportClub(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3)));
		} else {
			resultOfSearch = null;
		}
		statement.close();
	}

	public void delete() throws SQLException {
		sportClubs = new ArrayList<SportClub>();
		Statement statement = DriverManager.getConnection(url, user, password).createStatement();
		String query = "DELETE FROM sportclub WHERE sections='" + deleteBySection + "'";
		statement.executeUpdate(query);
		String query1 = "SELECT * FROM sportclub";
		ResultSet rs = statement.executeQuery(query1);
		while (rs.next()){
			sportClubs.add(new SportClub(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3))));
		}
		statement.close();
	}

	public void addToDb() throws SQLException {
		sportClubs = new ArrayList<SportClub>();
		Statement statement = DriverManager.getConnection(url, user, password).createStatement();
		String query = "INSERT INTO sportclub(sections, FIO, price) VALUES('" + section + "', '" + FIO + "', '" + price + "')";
		statement.executeUpdate(query);
		String query1 = "SELECT * FROM sportclub";
		ResultSet rs = statement.executeQuery(query1);
		while (rs.next()){
			sportClubs.add(new SportClub(rs.getString(1), rs.getString(2), Double.parseDouble(rs.getString(3))));
		}
		statement.close();
	}

	public List<SportClub> getSportClubs() {
		return sportClubs;
	}

	public void setSportClubs(List<SportClub> sportClubs) {
		this.sportClubs = sportClubs;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getFIO() {
		return FIO;
	}

	public void setFIO(String FIO) {
		this.FIO = FIO;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getSearchBySection() {
		return searchBySection;
	}

	public void setSearchBySection(String searchBySection) {
		this.searchBySection = searchBySection;
	}

	public SportClub getResultOfSearch() {
		return resultOfSearch;
	}

	public void setResultOfSearch(SportClub resultOfSearch) {
		this.resultOfSearch = resultOfSearch;
	}

	public String getDeleteBySection() {
		return deleteBySection;
	}

	public void setDeleteBySection(String deleteBySection) {
		this.deleteBySection = deleteBySection;
	}
}