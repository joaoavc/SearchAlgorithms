from abc import abstractmethod
from problema import Problema
class ProblemaHeuristica(Problema):
    
    def __init__(self, estado_inicial, operadores):
        super().__init__(estado_inicial, operadores)
    
    @abstractmethod
    def objetivo(self, estado): raise NotImplementedError("Método abstrato")