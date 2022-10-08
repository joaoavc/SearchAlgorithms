import math
import os
import sys
sys.path.append("..")
from arrumacao.instalacao_industrial import *
from arrumacao.agir import *
from arrumacao.acao import *
from arrumacao.arrumacao_problema import *
from arrumacao.arrumacao_estado import *
from arrumacao.arrumacao_operador import *
from informada import ProcuraAEstrela
from informada import ProcuraSofrega


class ArrumacaoAutomatica:
    
    def __init__(self, ficheiro_path):
        '''
        Planeamento da arrumação automatica
        
        Parameters
        ----------
        ficheiro_path : str

        '''
        self.instalacao_industrial = InstalacaoIndustrial(ficheiro_path)
        self.agir = Agir(self.instalacao_industrial)
        
        
    def realiza_procura(self, mecanismo_procura):
        '''
        Realização do procura 

        Parameters
        ----------
        mecanismo_procura : MecanismoProcura

        Returns
        -------
        solucao : Percurso

        '''
        
        operadores = [ArrumacaoOperador(Acao.AVANÇAR_ESTE, 1.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_SUL, 1.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_NORTE, 1.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_OESTE, 1.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_ESTE, 1.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_NORDESTE, 2.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_NOROESTE, 2.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_SUDESTE, 2.0, self.agir),
                      ArrumacaoOperador(Acao.AVANÇAR_SUDOESTE, 2.0, self.agir),
            ]
        problema_arrumar = ArrumacaoProblema(self.instalacao_industrial.get_estado_inicial(), 
                                             self.instalacao_industrial.get_estado_final(), 
                                             operadores)
        solucao = mecanismo_procura.resolver(problema_arrumar)
        return solucao
    
    
    def criar_resposta_ficheiro(self):
        '''
        Criação de um novo ficheiro "resposta.txt"
        Caso já exista o ficheiro resposta, este é apagado, para que o novo possa ser criado. 
        
        Returns
        -------
        file : ficheiro da resposta do planeamento
        '''
        filePath = "planeamento/resposta.txt"
        if os.path.exists(filePath):
            os.remove(filePath)
        else:
            print("Não pode apagar um ficheiro que não existe")
        file = open(filePath , "x")
        return file
    
    
    def armazenar_solucao(self, solucao):
        '''
        Armazenamento da solução encontrada pela aplicação

        Parameters
        ----------
        solucao : Percurso

        '''
        file = self.criar_resposta_ficheiro()
        for passo in solucao :
            operador = passo.get_operador()
            if(operador != None):
                acao_index = operador.get_acao().value
                file.write(str(acao_index)+ '\n')
