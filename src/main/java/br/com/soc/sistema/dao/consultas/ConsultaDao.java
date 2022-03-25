package br.com.soc.sistema.dao.consultas;

import br.com.soc.sistema.dao.Dao;
import br.com.soc.sistema.vo.ConsultaVo;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConsultaDao extends Dao {

    public List<ConsultaVo> findAllConsultas() {
	StringBuilder query = new StringBuilder(
		"SELECT cd_consulta id, nm_exame exame, nm_funcionario funcionario, dt_consulta data ")
			.append("FROM consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta ")
			.append("LEFT JOIN funcionario ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta ")
			.append("ORDER BY dt_consulta");
	try (Connection con = getConexao();
		PreparedStatement ps = con.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery()) {
	    ConsultaVo vo = null;
	    SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
	    List<ConsultaVo> consultas = new ArrayList<>();
	    while (rs.next()) {
		vo = new ConsultaVo();
		vo.setCdConsulta(rs.getString("id"));
		vo.setNmExame(rs.getString("exame"));
		vo.setNmFuncionario(rs.getString("funcionario"));
		vo.setData(sdt.format(rs.getDate("data")));

		consultas.add(vo);
	    }

	    return consultas;
	} catch (SQLException e) {
	    e.printStackTrace();
	}

	return Collections.emptyList();
    }

    public void insertConsulta(ConsultaVo consultaVo) {
	StringBuilder query = new StringBuilder(
		"INSERT INTO consulta (cd_exame_consulta, cd_funcionario_consulta, dt_consulta) ")
			.append("VALUES (?, ?, ?)");
	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdExame()));
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdFuncionario()));
	    ps.setDate(i++, Date.valueOf(consultaVo.getData()));
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void deleteConsulta(Integer codigo) {
	StringBuilder query = new StringBuilder("DELETE FROM consulta WHERE cd_consulta = ?");
	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setInt(i++, codigo);
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public void updateConsulta(ConsultaVo consultaVo) {
	StringBuilder query = new StringBuilder(
		"UPDATE consulta SET cd_exame_consulta = ?, cd_funcionario_consulta = ?, dt_consulta = ? WHERE cd_consulta = ?");
	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdExame()));
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdFuncionario()));
	    ps.setDate(i++, Date.valueOf(consultaVo.getData()));
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdConsulta()));
	    ps.executeUpdate();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
    }

    public ConsultaVo findByCodigo(Integer codigo) {
	StringBuilder query = new StringBuilder("SELECT cd_consulta id, cd_exame_consulta cdExame, nm_exame exame, ")
		.append("cd_funcionario_consulta cdFuncionario, nm_funcionario funcionario, dt_consulta data FROM ")
		.append("consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta LEFT JOIN funcionario ")
		.append("ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta WHERE cd_consulta = ?");

	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setInt(i, codigo);

	    try (ResultSet rs = ps.executeQuery()) {
		ConsultaVo vo = null;
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		while (rs.next()) {
		    vo = new ConsultaVo();
		    vo.setCdConsulta(rs.getString("id"));
		    vo.setCdExame(rs.getString("cdExame"));
		    vo.setNmExame(rs.getString("exame"));
		    vo.setCdFuncionario(rs.getString("cdFuncionario"));
		    vo.setNmFuncionario(rs.getString("funcionario"));
		    vo.setData(sdt.format(rs.getDate("data")));
		}
		return vo;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<ConsultaVo> findConsultasByDate(ConsultaVo consultaVo) {
	StringBuilder query = new StringBuilder("SELECT cd_consulta id, cd_exame_consulta cdExame, nm_exame exame, ")
		.append("cd_funcionario_consulta cdFuncionario, nm_funcionario funcionario, dt_consulta data FROM ")
		.append("consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta LEFT JOIN funcionario ")
		.append("ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta WHERE dt_consulta BETWEEN (?) AND (?) ")
		.append("ORDER BY dt_consulta");

	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setDate(i++, Date.valueOf(consultaVo.getDataInicial()));
	    ps.setDate(i++, Date.valueOf(consultaVo.getDataFinal()));

	    try (ResultSet rs = ps.executeQuery()) {
		ConsultaVo vo = null;
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
		List<ConsultaVo> consultas = new ArrayList<>();

		while (rs.next()) {
		    vo = new ConsultaVo();
		    vo.setCdConsulta(rs.getString("id"));
		    vo.setCdExame(rs.getString("cdExame"));
		    vo.setNmExame(rs.getString("exame"));
		    vo.setCdFuncionario(rs.getString("cdFuncionario"));
		    vo.setNmFuncionario(rs.getString("funcionario"));
		    vo.setData(sdt.format(rs.getDate("data")));

		    consultas.add(vo);
		}
		return consultas;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public ConsultaVo findDuplicada(ConsultaVo consultaVo) {
	StringBuilder query = new StringBuilder(
		"SELECT cd_exame_consulta cdExame, cd_funcionario_consulta cdFuncionario, ").append(
			"dt_consulta data FROM consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta ")
			.append("LEFT JOIN funcionario ON funcionario.cd_funcionario = consulta.cd_funcionario_consulta ")
			.append("WHERE cd_exame_consulta = ? AND cd_funcionario_consulta = ? AND dt_consulta = ?");

	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdExame()));
	    ps.setInt(i++, Integer.parseInt(consultaVo.getCdFuncionario()));
	    ps.setDate(i++, Date.valueOf(consultaVo.getData()));

	    try (ResultSet rs = ps.executeQuery()) {
		ConsultaVo vo = null;
		SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");

		while (rs.next()) {
		    vo = new ConsultaVo();
		    vo.setCdExame(rs.getString("cdExame"));
		    vo.setCdFuncionario(rs.getString("cdFuncionario"));
		    vo.setData(sdt.format(rs.getDate("data")));
		}
		return vo;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }

    public List<ConsultaVo> findMelhoresConsultas(ConsultaVo consultaVo) {
	StringBuilder query = new StringBuilder("SELECT count(cd_exame_consulta) qtdExame, nm_exame nmExame ")
		.append("FROM consulta LEFT JOIN exame ON exame.cd_exame = consulta.cd_exame_consulta ")
		.append("WHERE dt_consulta BETWEEN (?) AND (?) GROUP BY cd_exame_consulta ")
		.append("ORDER BY count(cd_exame_consulta) DESC LIMIT 5;");

	try (Connection con = getConexao(); PreparedStatement ps = con.prepareStatement(query.toString())) {
	    int i = 1;
	    ps.setDate(i++, Date.valueOf(consultaVo.getDataInicial()));
	    ps.setDate(i++, Date.valueOf(consultaVo.getDataFinal()));

	    try (ResultSet rs = ps.executeQuery()) {
		ConsultaVo vo = null;
		List<ConsultaVo> consultas = new ArrayList<>();

		while (rs.next()) {
		    vo = new ConsultaVo();
		    vo.setQtdExame(rs.getString("qtdExame"));
		    vo.setNmExame(rs.getString("nmExame"));

		    consultas.add(vo);
		}
		return consultas;
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return null;
    }
}
