from abc import abstractmethod
import sys
sys.path.append("..")
from procura import MecanismoProcura
from memoria import MemoriaPrioridade
class ProcuraMelhorPrimeiro(MecanismoProcura):
    
    def iniciar_memoria(self):
        return MemoriaPrioridade()
    
    @abstractmethod
    def f(self, no): raise NotImplementedError("Método abstrato")
    
    def avaliacao(self, no):
        '''
        Avalição do No atraves da função f

        Parameters
        ----------
        no :No

        Returns
        -------
        TYPE :int
        '''
        return self.f(no)
  