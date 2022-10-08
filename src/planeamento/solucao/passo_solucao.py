from abc import ABC, abstractmethod
class PassoSolucao(ABC):
    
    @abstractmethod
    def get_estado(): raise NotImplementedError("Método abstrato")
    
    @abstractmethod
    def get_operador(): raise NotImplementedError("Método abstrato")
    
    @abstractmethod
    def get_custo(): raise NotImplementedError("Método abstrato")
