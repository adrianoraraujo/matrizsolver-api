package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.Conexao;

public class MatrizDAO
{
	Connection connection;
	Conexao conexao;

	public MatrizDAO()
	{
		conexao = Conexao.getConexao();
		connection = conexao.getConnection();
	}

	public boolean cadastrarMatriz(int userid, String result)
	{
		try
		{
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO results VALUES (?, ?) ON DUPLICATE KEY UPDATE result=?");
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

	public String getMatriz(int userid)
	{
		try
		{
			PreparedStatement stmt = connection.prepareStatement("SELECT result FROM results, users WHERE results.userid=users.userid AND results.userid=?");
			stmt.setInt(1, userid);
			ResultSet valores = stmt.executeQuery();
			if (valores.next())
				return valores.getString(1);
		} catch (SQLException e)
		{
			return null;
		}
		return null;
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
