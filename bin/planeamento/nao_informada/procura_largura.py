import sys
sys.path.append("..")

from procura import MecanismoProcura
from procura import Procura
from memoria import MemoriaFIFO

class ProcuraLargura(MecanismoProcura, Procura):
    
    def iniciar_memoria(self):
        '''
        Inicializa memória FIFO

        Returns
        -------
        MemoriaFIFO 

        '''
        return MemoriaFIFO()
    
    