package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao
{
	private Connection connection = null;

	private static Conexao conexao;

	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}

	private Conexao()
	{
		try
		{
			connection = DriverManager.getConnection("jdbc:mysql://luizhrios.ddns.net/matrizsolver?useSSL=true&verifyServerCertificate=false", "matrizsolver", "DGZiNTyGnt5T6Qx0");
		} catch (SQLException e)
		{
			System.out.println("Erro ao conectar com o banco: " + e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConnection()
	{
		return connection;
	}

	public static Conexao getConexao()
	{
		if (conexao == null)
			conexao = new Conexao();
		return conexao;
	}

	public void closeConnection()
	{
		try
		{
			connection.close();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

}
