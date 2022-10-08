from abc import ABC, abstractmethod
class Solucao(ABC):
    
    @abstractmethod
    def get_custo(): raise NotImplementedError("Método abstrato")
    
    @abstractmethod
    def get_dimensao(): raise NotImplementedError("Método abstrato")