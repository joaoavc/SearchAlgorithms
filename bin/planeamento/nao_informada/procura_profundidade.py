import sys
sys.path.append("..")


from procura import MecanismoProcura
from procura import Procura
from memoria import MemoriaLIFO

class ProcuraProfundidade(MecanismoProcura, Procura):
    
    def iniciar_memoria(self):
         '''
        Inicializa memória LIFO

        Returns
        -------
        MemoriaLIFO

        '''
         return MemoriaLIFO()
    