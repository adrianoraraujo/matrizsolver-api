package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.Conexao;

public class UserDAO
{
	Connection connection;
	Conexao conexao;

	public UserDAO()
	{
		conexao = Conexao.getConexao();
		connection = conexao.getConnection();
	}

	public int cadastrarUsuario()
	{
		boolean idExists = false;
		do
		{
			try
			{
				Statement stmt = connection.createStatement();
				ResultSet randomid = stmt.executeQuery("SELECT RAND()*1000000000");
				randomid.next();
				int userid = randomid.getInt(1);
				stmt.execute("INSERT INTO users VALUES (" + userid + ")");
				return userid;
			} catch (SQLException e)
			{
				idExists = true;
				e.printStackTrace();
			}
		} while (idExists == true);
		return -1;
	}

}
