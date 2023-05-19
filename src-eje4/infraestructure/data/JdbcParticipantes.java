package infraestructure.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import domain.portsou.Observador;
import domain.portsou.RepositorioException;

public class JdbcParticipantes implements Observador {

	private static String       DRIVER = "com.mysql.jdbc.Driver";
	private static String       URL_DB = "jdbc:mysql://localhost:3306/";
	protected static String     DB     = "participantes2";              // nombre de mi BD
	protected static String     user   = "root";
	protected static String     pass   = "";
	protected static Connection conn;                                   // = null;

//-----------------------------------------------------------------------
	private void connect() {
		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}
	}

	private void disconnect() {
		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				throw new RepositorioException(e, "Error con la Base de datos");
			}
		}
	}

//----------------------------------------------------------------------- 
	@Override
	public void actualizar(String datos) {

		this.connect();

		String arreglo[] = separarDatos(datos);
		try {
			PreparedStatement statement = conn // "INSERT INTO participante(Nombre,id_part,DNI,Puntos)--> van los campos
												// de la tabla
					.prepareStatement("INSERT INTO participante4(nombre,telefono,region,email) " + "VALUES (?,?,?,?)");
			statement.setString(1, arreglo[0]); // campos
			statement.setString(2, arreglo[1]);
			statement.setString(3, arreglo[2]);
			statement.setString(4, arreglo[3]);
			statement.executeUpdate(); //

		} catch (SQLException e) {
			throw new RepositorioException("Error al intentar conectarse con la BD.");
		} finally {
			this.disconnect();
		}

	}

	private String[] separarDatos(String datos) {

		String   separados[] = datos.split("\\|");

		String[] arreglo     = { separados[0], separados[1], separados[2], separados[3] };

		return arreglo;

	}

}
