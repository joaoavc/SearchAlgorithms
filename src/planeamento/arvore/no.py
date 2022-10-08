import sys
sys.path.append("..")
from solucao import PassoSolucao

class No(PassoSolucao):
    
    def __init__(self, estado, operador=None, antecessor=None):
        '''
        Construtor da classe que representa o No

        Parameters
        ----------
        estado : Estado
        operador : Operador, optional
        antecessor : No, optional
         
        Raises
        ------
        Exception

        '''
        self.estado = estado
        if operador is None and antecessor is None:
            self.custo = 0
            self.profundidade = 0
            self.antecessor = None
            self.operador = None
            print("Nó raiz!")
            
        elif operador is not None and antecessor is not None:
            self.operador = operador
            self.antecessor = antecessor
            self.profundidade = self.antecessor.get_profundidade() + 1
            self.custo = self.antecessor.get_custo() + self.operador.get_custo()

        else:
            raise Exception("Nó mal construído")
        
    
    def get_estado(self): 
        '''
        Devolve o estado do No

        Returns
        -------
        TYPE :Estado
        '''
        return self.estado
    
        
    def get_profundidade(self):
        '''
        Devolve a profundidade do No

        Returns
        -------
        TYPE :int
        '''
        return self.profundidade
    
    
    def set_profundidade(self, profundidade):
        '''
        Define a profundidade do No

        Parameters
        ----------
        profundidade : int

        '''
        self.profundidade = profundidade
    

    def get_custo(self):
        '''
        Devolve o custo do No

        Returns
        -------
        TYPE :float
        '''
        return self.custo
    
    
    def set_custo(self, custo):
        '''
        Define o custo do No

        Parameters
        ----------
        custo : float
        '''
        self.custo = custo


    def get_operador(self):
        '''
        Devolve o Operador do No

        Returns
        -------
        TYPE :Operador
        '''
        return self.operador
    

    def get_antecessor(self): 
        '''
        Devolve o No antecessor do No

        Returns
        -------
        TYPE :No
        '''
        return self.antecessor
