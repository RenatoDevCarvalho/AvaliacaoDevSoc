package br.com.soc.sistema.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import br.com.soc.sistema.vo.FuncionarioVo;

@WebService
@SOAPBinding(style = Style.RPC)
public interface WebServiceFuncionarios {
	@WebMethod
	public void inserirFuncionario(FuncionarioVo funcionarioVo);

	@WebMethod
	public void excluirFuncionario(String codigo);
	
	@WebMethod
	public void editarFuncionario(FuncionarioVo funcionarioVo);
	
	@WebMethod
	public String buscarFuncionario(String codigo);
}
