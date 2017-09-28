/* 
 * Writes the "BODY" tag: specifies the "BACKGROUND"
 */
var corLinha  = "#000080";  /* cor das linhas que antecedem e precedem os separadores  */
var corTitulo = "#0000FF";  /* cor do texto que aparece entre linhas */

 

/* 
 * Escreve o separador de sec&ccedil;&otilde;es nos enunciados
 */
function Separador (texto) { 
  //  document.writeln('<P>&nbsp;</P>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  document.writeln('<B><FONT CLASS="titulo">',texto,'</FONT></B>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  return true;
}

/*
 * Escreve o texto da submissao de um exercicio de programacao
 * E' so' necessario indicar o nome do exercicio.
 */
function RegrasSubmissaoEP(ep) {
  Separador ('Submiss&atilde;o');
  document.writeln('<p>Ap&oacute;s obter as classes que obede&ccedil;am &agrave;s');
  document.writeln('especifica&ccedil;&otilde;es fornecidas, crie um ficheiro jar,');
  document.writeln('denominado ', ep, '.jar ", contendo apenas os ficheiros fonte \(.java\) de');
  document.writeln('todas as classes concretizadas. Se todas as classes estiverem');
  document.writeln('no mesmo direct&oacute;rio, deve ser dado o seguinte comando:</p>');
  document.writeln('<blockquote>');
  document.writeln('  <pre>       jar -cvf ', ep, '.jar *.java<br> </pre>');
  document.writeln('</blockquote>');
  EntregaAutomatica(ep + '.jar');
}




/* 
 * Escreve a mensagem com a pagina de submissao.
 *
 * ficheiro e' o nome do ficheiro a enviar
 */
function EntregaAutomatica(file) { 
  document.writeln('<p> Usando o <a href="https://fenix.ist.utl.pt/publico/executionCourse.do?sectionID=5259&executionCourseID=46510&method=section">sistema de submiss&otilde;es</a>, enviar o ficheiro "', file, '" para avalia&ccedil;&atilde;o.<br/>');
  document.writeln('O trabalho pode ser submetido v&aacute;rias vezes, at&eacute; &agrave; data limite de entrega. Ser&aacute; apenas');
  document.writeln('avaliada a &uacute;ltima vers&atilde;o entregue. </p>');
}

/* 
 * Escreve o cabe&ccedil;alho dos enunciados
* aulaLaboratorio - numero da aula em que o trabalho é entregue aos alunos.
 */
function Cabecalho(prova, nomeProva,IG, LT, LE, limite, aulaLaboratorio) { 
  document.writeln('<H2>PROGRAMA&Ccedil;&Atilde;O COM OBJECTOS 2017/2018</H2>');
  document.write  ('<H3>');
  escolheProva(prova, nomeProva);
  document.writeln('</H3>');
  //document.writeln('<P>&nbsp;</P>');

  document.writeln('<CENTER>');
  document.writeln('<TABLE BORDER="0" CELLSPACING="2" CELLPADDING="0" BGCOLOR="#F0F0F0">');
  escolhe(IG, 'A realizar', 'individualmente', 'em grupo');
  escolhe(LT, 'Local de trabalho', 'aula pr&aacute;tica', 'casa (TPC)');
  escolhe(LE, 'Local de entrega',  'aula pr&aacute;tica', 'submiss&atilde;o electr&oacute;nica');
    escolheLimite(limite, aulaLaboratorio);
  document.writeln('</TABLE>');
  document.writeln('</CENTER>');
  document.writeln('<P>&nbsp;</P>');
  return true;
}

function escolhe(selector,propriedade, valorA, valorB) { 
  document.writeln('<TR>');
  document.writeln('<TD height="30pt"> <B><FONT COLOR="navy"> &nbsp;&nbsp;&nbsp;&nbsp;', propriedade,': </FONT></TD>');
  document.write  ('<TD><IMG SRC="box');
  if (selector ==1) document.write('F'); else document.write('E');
  document.writeln('.jpg" ALT="Empty checkbox" BORDER="0" align="bottom" width="20pt">&nbsp;&nbsp; </TD>');
  document.writeln('<TD>');
  if (selector ==1) document.write('<B><FONT COLOR="red">');
  document.writeln(valorA, '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');
  if (selector ==1) document.write('</FONT></B>');
  document.writeln('</TD>');
  document.write  ('<TD><IMG SRC="box');
  if (selector ==1) document.write('E'); else document.write('F');
  document.writeln('.jpg" ALT="Empty checkbox" BORDER="0" align="bottom" width="20pt">&nbsp;&nbsp; </TD>');
  document.writeln('<TD>');
  if (selector ==2) document.writeln('<B><FONT COLOR="red">');
  document.writeln(valorB, '&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');
  if (selector ==2) document.writeln('</FONT></B>');
  document.writeln('</TD></TR>');
  return true;
}

function escolheLimite(limite, aulaLaboratorio) { 
  document.writeln('<TR>');
  document.write  ('<TD height="30pt"> <B><FONT COLOR="navy">  &nbsp;&nbsp;&nbsp;&nbsp;');
  document.writeln('Data limite entrega:&nbsp;&nbsp;&nbsp;</FONT></TD>');
  document.write  ('<TD colspan ="4"> <B><FONT COLOR="red">');
    if (limite == 1) document.writeln('  Durante a aula pr&aacute;tica n&uacute;mero ', aulaLaboratorio);
  if (limite == 2) {
    document.write('   At&eacute; ao in&iacute;cio da aula pr&aacute;tica n&uacute;mero ');
      aulaLaboratorio++;
      document.writeln(aulaLaboratorio);

  }
  //if (limite == 3) document.write('at&eacute; &agrave;s 18:00 do dia ');
  document.writeln('</FONT></B></TD>');
  document.writeln('</TR>');
  return true;
}

function escolheProva(prova,nomeProva) { 
  if (prova == 1) document.write('Exerc&iacute;cio de Avalia&ccedil;&atilde;o ', nomeProva);
  if (prova == 2) document.write('Projecto N&ordm; ', nomeProva, ' &mdash; P', nomeProva);
  return true;
}



/* 
 * Escreve enunciado de trabalho a fazer na aula
 */
function FazNaAulaMC(metodo, classe) { 
  Separador('Enunciado');
  document.write  ('Implemente o m&eacute;todo <I><U>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');
  document.write  (metodo);
  document.writeln('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</U></I> ');
  document.write  ('da classe <I><U>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;');
  document.write  (classe);
  document.writeln('&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</U></I> descrita na aula.');
  for (i=18 ; i>0 ; i--) 
   	document.writeln('<P>&nbsp;</P>');
  return true;
}

/* 
 * Escreve enunciado de trabalho a fazer na aula
 */
function FazNaAula(texto) { 
  Separador('Enunciado');
  document.write  (texto);
  for (i=18 ; i>0 ; i--) 
   	document.writeln('<P>&nbsp;</P>');
  return true;
}



/* 
 * Escreve 5 linhas
 */
function Linhas() { 
  document.writeln('<BLOCKQUOTE>'  );
  document.writeln('<BLOCKQUOTE><BR>'  );
  document.writeln('<HR SIZE="1" CLASS="dobro">');
  document.writeln('<HR SIZE="1" CLASS="dobro">');
  document.writeln('<HR SIZE="1" CLASS="dobro">');
  document.writeln('<HR SIZE="1" CLASS="dobro">');
  document.writeln('<HR SIZE="1" CLASS="dobro">');
  document.writeln('</BLOCKQUOTE>' );
  document.writeln('</BLOCKQUOTE>' );
  return true;
}


/* 
 * Escreve sec&ccedil;&atilde;o para identificar o aluno que realizou o trabalho
 */
function IdentificaAluno () { 
  //document.writeln('<P>&nbsp;</P>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  document.writeln('<B><FONT CLASS="titulo"> Identifica&ccedil;&atilde;o do aluno que realizou este trabalho</FONT></B>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  document.writeln('<P>');
  document.writeln('Grupo N&ordm;: ________');
  document.writeln('</P>');
  document.writeln('<P>');
  document.writeln('Aluno N&ordm;: ________   Nome (primeiro e &uacute;ltimo): ____________________________________________<BR>');
  document.writeln('</P>');
  return true;
}


/* 
 * Escreve sec&ccedil;&atilde;o para identificar os alunos que realizaram o trabalho
 */
function IdentificaAlunos () { 
  //document.writeln('<P>&nbsp;</P>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  document.writeln('<B><FONT CLASS="titulo"> Identifica&ccedil;&atilde;o dos alunos que realizaram este trabalho</FONT></B>');
  document.writeln('<HR SIZE="2pt" COLOR="',corLinha,'">');
  document.writeln('<P>');
  document.writeln('Grupo N&ordm;: ________');
  document.writeln('</P>');
  document.writeln('<P>');
  document.writeln('Aluno N&ordm;: ________   Nome (primeiro e &uacute;ltimo): ____________________________________<BR>');
  document.writeln('</P>');
  document.writeln('<P>');
  document.writeln('Aluno N&ordm;: ________   Nome (primeiro e &uacute;ltimo): ____________________________________<BR>');
  document.writeln('</P>');
  //document.writeln('<P>');
  //document.writeln('Aluno N&ordm;: ________   Nome (primeiro e &uacute;ltimo): ____________________________________<BR>');
  //document.writeln('</P>');
  return true;
}
