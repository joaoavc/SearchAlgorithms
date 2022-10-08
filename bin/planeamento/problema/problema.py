from abc import ABC, abstractmethod
class Problema(ABC):
    
    def __init__(self, estado_inicial, operadores):
        self.estado_inicial = estado_inicial
        self.operadores = operadores
        
    def get_operadores(self):
        return self.operadores
        
    def get_estado_inicial(self):
        return self.estado_inicial
        
    @abstractmethod
    def objetivo(self, estado): raise NotImplementedError("Método abstrato")
        