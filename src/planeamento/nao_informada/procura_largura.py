import sys
sys.path.append("..")

from procura import MecanismoProcura
from memoria import MemoriaFIFO

class ProcuraLargura(MecanismoProcura):
    
    def iniciar_memoria(self):
        '''
        Inicializa memória FIFO

        Returns
        -------
        MemoriaFIFO 

        '''
        return MemoriaFIFO()
    
    
