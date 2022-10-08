from abc import ABC, abstractmethod
from arvore import No
from arvore import Percurso
class MecanismoProcura(ABC):
    
    def __init__(self):
        '''
        Aspetos gerais dos diferentes mecanismos de procura
        '''
        self.memoria_procura = self.iniciar_memoria()
        self.problema = None
        
        
    @abstractmethod
    def iniciar_memoria(self): raise NotImplementedError("Método abstrato")
    
    
    def resolver(self, problema, prof_max=None):
        '''
        Resolver o problema, devolvendo uma solução
        
        Parameters
        ----------
        problema :Problema
        prof_max :int, optional
            
        Returns
        -------
        TYPE :Percurso
        '''
        self.problema = problema
        self.memoria_procura.limpar()
        if(prof_max is None):
            prof_max = -1
        
        no_inicial = No(self.problema.get_estado_inicial())
        self.memoria_procura.inserir(no_inicial, self.avaliacao(no_inicial))
    
        while(not self.memoria_procura.fronteira_vazia()):
            no = self.memoria_procura.remover()
            
            if(self.problema.objetivo(no.get_estado())):
                return self.gerar_solucao(no)
            
            if(no.get_profundidade() < prof_max or prof_max == -1):
                self.expandir(no)
    

    def expandir(self, no):
        '''
        Expansão do No

        Parameters
        ----------
        no :No

        '''
        estado = no.get_estado()
        operadores = self.problema.get_operadores()
        
        for operador in operadores:
            novo_estado = operador.aplicar(estado)
            
            if(novo_estado != None):
                no_sucessor = No(novo_estado, operador, no)
                self.memoria_procura.inserir(no_sucessor, self.avaliacao(no_sucessor))
   
    
    def gerar_solucao(self, no):
        '''
        Após ter sido encontrado o objetivo, é feito o 
        backtracking necessário para que seja possível gerar a solução

        Parameters
        ----------
        no :No

        Returns
        -------
        percurso :Percurso

        '''
        percurso = Percurso()
        while(no != None):
            percurso.juntar_inicio(no)
            no = no.get_antecessor()
        return percurso
    
    
    def get_problema(self):
        '''
        Devolve o problema 

        Returns
        -------
        TYPE :Problema
        '''
        return self.problema
    
    
    def avaliacao(self, no): 
        '''
        Avaliação do No

        Parameters
        ----------
        no :No

        Returns
        -------
        int
        '''
        return 0
    