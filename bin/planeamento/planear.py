'''
Aplicação de planeamento
'''

from arrumacao.arrumacao_automatica import ArrumacaoAutomatica
from informada import  ProcuraAEstrela

arrumacao_auto = ArrumacaoAutomatica("planeamento/pedido.txt")
procura = ProcuraAEstrela()
solucao = arrumacao_auto.realiza_procura(procura)
arrumacao_auto.armazenar_solucao(solucao)