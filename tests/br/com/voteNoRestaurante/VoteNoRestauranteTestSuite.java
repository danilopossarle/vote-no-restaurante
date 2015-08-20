package br.com.voteNoRestaurante;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.voteNoRestaurante.controllers.ProcessamentoVotosControllerTest;
import br.com.voteNoRestaurante.services.HomeServiceTest;
import br.com.voteNoRestaurante.services.ProcessamentoServiceTest;
import br.com.voteNoRestaurante.services.ResultadoServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ProcessamentoVotosControllerTest.class, HomeServiceTest.class, ProcessamentoServiceTest.class, ResultadoServiceTest.class})
public class VoteNoRestauranteTestSuite {

}
