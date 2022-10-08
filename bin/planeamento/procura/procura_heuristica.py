from abc import ABC, abstractmethod
class ProcuraHeuristica:
    
    @abstractmethod
    def resolver(self, problema, prof_max=None): raise NotImplementedError("Método abstrato")
    
    