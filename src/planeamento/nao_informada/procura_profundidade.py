import sys
sys.path.append("..")


from procura import MecanismoProcura
from memoria import MemoriaLIFO

class ProcuraProfundidade(MecanismoProcura):
    
    def iniciar_memoria(self):
         '''
        Inicializa memória LIFO

        Returns
        -------
        MemoriaLIFO

        '''
         return MemoriaLIFO()
    
