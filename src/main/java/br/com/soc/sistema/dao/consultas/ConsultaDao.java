package br.com.soc.sistema.dao.consultas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ConsultaVo;

public class ConsultaDao extends Dao {

	public List<ConsultaVo> findAllConsultas() {
		StringBuilder query = new StringBuilder(
				"SELECT cd_consulta id, nm_exame exame, nm_funcionario funcionario, dt_consulta data ")
						.append("FROM consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta ")
						.append("LEFT JOIN funcionario ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta");
		try (Connection con = getConexao();
				PreparedStatement ps = con.prepareStatement(query.toString());
				ResultSet rs = ps.executeQuery()) {
			ConsultaVo vo = null;
			List<ConsultaVo> consultas = new ArrayList<>();
			while (rs.next()) {
				vo = new ConsultaVo();
				vo.setCdConsulta("id");
				vo.setNmExame("exame");
				vo.setNmFuncionario("funcionario");
				vo.setData("data");

				consultas.add(vo);
			}
			return consultas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}

}
