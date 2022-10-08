from abc import ABC, abstractmethod
class Procura(ABC):
    
    @abstractmethod
    def resolver(self, problema, prof_max=None): raise NotImplementedError("Método abstrato")
    
    