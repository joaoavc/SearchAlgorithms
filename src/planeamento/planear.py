'''
Aplicação de planeamento automático, a
qual disponibiliza um serviço de planeamento de trajectos. 
'''


from arrumacao.arrumacao_automatica import ArrumacaoAutomatica
from informada import *
from nao_informada import *

arrumacao_auto = ArrumacaoAutomatica("planeamento/pedido.txt")

'''
                    <-- IMPORTANTE -->

DESCOMENTE O METODO DE PROCURA QUE PRETENDE USAR
E COMENTE OS RESTANTES (usar ficheiro teste.bat após a escolha
do metodo como teste)

'''
procura = ProcuraAEstrela()
#procura = ProcuraSofrega()
#procura = ProcuraLargura()
#procura = ProcuraProfundidade()
#procura = ProcuraCustoUniforme()
solucao = arrumacao_auto.realiza_procura(procura)
arrumacao_auto.armazenar_solucao(solucao)
