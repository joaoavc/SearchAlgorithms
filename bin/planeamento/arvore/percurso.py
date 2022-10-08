import sys
sys.path.append("..")

from solucao import Solucao


class Percurso(Solucao):
    
    def __init__(self):
        '''
        Classe Percurso, representa o percurso obtido como solução do problema
        '''
        self.lista_passos = []
    
    
    def get_dimensao(self):
        '''
        Devolve a dimensão do percurso

        Returns
        -------
        dimensao :int
        '''
        dimensao = 0 if not self.lista_passos else len(self.lista_passos)
        return dimensao
        
    
    def get_custo(self):
        '''
        Devolve o custo do percurso

        Returns
        -------
        custo :int
        '''
        custo = 0 if not self.lista_passos else self.lista_passos[-1].get_custo()
        return custo
    
    
    def __iter__(self):
        '''
        Percurso é um iterator

        Returns
        -------
        TYPE :iterator

        '''
        return iter(self.lista_passos)
        
    
    def juntar_inicio(self, no):
        '''
        Permite juntar o No ao inicio do percurso,
        pois a adição dos nos é feita num processo de 
        backtracking

        Parameters
        ----------
        no :No

        '''
        self.lista_passos.insert(0, no)