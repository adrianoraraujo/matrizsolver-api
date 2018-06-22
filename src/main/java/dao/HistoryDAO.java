package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexao;

public class HistoryDAO
{
	Connection connection;
	Conexao conexao;

	public HistoryDAO()
	{
		conexao = Conexao.getConexao();
		connection = conexao.getConnection();
	}

	public boolean registerHistory(int userid, String result)
	{
		try
		{
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO history VALUES (?, ?) ON DUPLICATE KEY UPDATE history=?");
			stmt.setInt(1, userid);
			stmt.setString(2, result);
			stmt.setString(3, result);
			stmt.execute();
			return true;
		} catch (SQLException e)
		{
			return false;
		}
	}

	public String getHistory(int userid)
	{
		try
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT history FROM history, users WHERE history.userid=users.userid AND history.userid=?");
			stmt.setInt(1, userid);
			ResultSet valores = stmt.executeQuery();
			if (valores.next())
				return valores.getString(1);
		} catch (SQLException e)
		{
			return null;
		}
		return "";
	}

	// public boolean deleteFirstMatriz(int userid)
	// {
	// try
	// {
	// PreparedStatement stmt = connection.prepareStatement("DELETE FROM results
	// WHERE userid=? TOP 1 ORDER BY order");
	// stmt.setInt(1, userid);
	// return stmt.execute();
	// } catch (SQLException e)
	// {
	// e.printStackTrace();
	// }
	// return false;
	// }

}
