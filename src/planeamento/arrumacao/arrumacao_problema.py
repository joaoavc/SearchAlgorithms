import math
from problema import ProblemaHeuristica

class ArrumacaoProblema(ProblemaHeuristica):
    
    def __init__(self, estado_inicial, estado_final, operadores):
        '''
        Definição do problema da arrumação numa instalação industrial

        Parameters
        ----------
        estado_inicial :ArrumacaoEstado
        estado_final :ArrumacaoEstado
        operadores : []
        '''
        super().__init__(estado_inicial, operadores)
        self.estado_final = estado_final
        
    
    def heuristica(self, estado):
        '''
        Heuristica do problema

        Parameters
        ----------
        estado :ArrumacaoEstado

        Returns
        -------
        TYPE :float
        '''
        return self.distancia_euclidiana(estado)
        
    
    def distancia_euclidiana(self, estado):
        '''
        Calculo da distacia euclidiana entre o estado e o estado objetivo

        Parameters
        ----------
        estado :ArrumacaoEstado

        Returns
        -------
        dist_euc :float
        '''
        dist_euc = math.sqrt(((self.estado_final.get_x() - estado.get_x() )**2) + ((self.estado_final.get_y() - estado.get_y() )**2))
        return dist_euc
        
    
    def objetivo(self, estado):
        '''
        Verifica se o estado é o objetivo

        Parameters
        ----------
        estado : estado

        Returns
        -------
        atingiu_objetivo :boolean

        '''
        atingiu_objetivo = self.estado_final.__eq__(estado)
        return atingiu_objetivo
