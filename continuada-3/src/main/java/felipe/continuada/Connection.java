
package felipe.continuada;

import java.util.List;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class Connection {
    
    public static JdbcTemplate conectarBanco() {
        
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/continuada3";
        String username = "root";
        String password = "bandtec";
                
        BasicDataSource infoBanco = new BasicDataSource();
        
        infoBanco.setDriverClassName(driver);
        infoBanco.setUrl(url);
        infoBanco.setUsername(username);
        infoBanco.setPassword(password);
        
        JdbcTemplate jdbcTemplate = new JdbcTemplate(infoBanco);
        
        return jdbcTemplate;
    }
    
    public static List<Usuario> selectUsuarios(String login, String senha) {
        JdbcTemplate jdbcTemplate = conectarBanco();
        
        List<Usuario> listaLogin = jdbcTemplate.query(
            "SELECT * FROM usuario WHERE nomeUser = ? AND senhaUser = ?",
                new BeanPropertyRowMapper(Usuario.class),
                    login, senha);
        
        return listaLogin;
    }
    
    public static List<ProdutoBanco> selectProdutos() {
        JdbcTemplate jdbcTemplate = conectarBanco();
        
        List<ProdutoBanco> listaProdutos = jdbcTemplate.query(
            "SELECT * FROM produto",
                new BeanPropertyRowMapper(ProdutoBanco.class));
        
        return listaProdutos;
    }
    
    public static void deleteProduto(ProdutoBanco produto) {
        JdbcTemplate jdbcTemplate = conectarBanco();
        
        jdbcTemplate.update("DELETE FROM produto WHERE id = ?", produto.getId());
        
    }
    
    public static void InsertProduto(String nomeProduto, Double valorProduto, Integer categoriaProduto) {
        JdbcTemplate jdbcTemplate = conectarBanco();
        
        jdbcTemplate.update(
            "INSERT INTO produto (nome, preco, categoria) VALUES (?, ?, ?)",
                nomeProduto, valorProduto, categoriaProduto
        );
    }
}
