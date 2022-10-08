import sys
sys.path.append("..")
from arrumacao.acao import *
from arrumacao.arrumacao_estado import *

class Agir:
    
   def __init__(self, instalacao_industrial):
       '''
       Simulação das ações possíveis

       Parameters
       ----------
       instalacao_industrial :InstalacaoIndustrial

       '''
       self.direcao_da_acao = {}
       self.set_direcao_acao()
       self.instalacao_industrial = instalacao_industrial
        
        
   def age(self, acao, estado):
       '''
       Simula da ação em um determinado estado, devolvendo
       o estado resultante dessa ação nesse estado

       Parameters
       ----------
       acao :Acao
       estado :ArrumacaoEstado

       Returns
       -------
       estado_seguinte :ArrumacaoEstado

       '''
       x = estado.get_x()
       y = estado.get_y()
       if(self.instalacao_industrial.posicao_obstaculo(x, y)): return None
       passo = self.direcao_da_acao.get(acao)
       new_x = x + passo[0]
       new_y = y + passo[1]
       estado_seguinte = ArrumacaoEstado(new_x, new_y)
       return estado_seguinte
        
        
   def set_direcao_acao(self):
       '''
       Define a direção do passo das adiferentes ações
       '''
       self.direcao_da_acao[Acao.AVANÇAR_ESTE] = (1, 0)
       self.direcao_da_acao[Acao.AVANÇAR_NORDESTE] = (1, -1)
       self.direcao_da_acao[Acao.AVANÇAR_NORTE] = (0, -1)
       self.direcao_da_acao[Acao.AVANÇAR_NOROESTE] = (-1, -1)
       self.direcao_da_acao[Acao.AVANÇAR_OESTE] = (-1, 0)
       self.direcao_da_acao[Acao.AVANÇAR_SUDOESTE] = (-1, 1)
       self.direcao_da_acao[Acao.AVANÇAR_SUL] = (0, 1)
       self.direcao_da_acao[Acao.AVANÇAR_SUDESTE] = (1,1)