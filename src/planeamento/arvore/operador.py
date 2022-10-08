from abc import ABC, abstractmethod


class Operador(ABC):
    
    @abstractmethod
    def aplicar(self, estado): raise NotImplementedError("Método abstrato")
    
    @abstractmethod
    def get_custo(self): raise NotImplementedError("Método abstrato")
    
