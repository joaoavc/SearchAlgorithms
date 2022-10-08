from arvore import Operador
class ArrumacaoOperador(Operador):
    
    def __init__(self, acao, custo, agir):
        '''
        Operador de arrumação automática

        Parameters
        ----------
        acao :Acao
        custo :float
        agir :Agir
        '''
        self.acao = acao
        self.custo = custo
        self.agir = agir
    
    
    def aplicar(self, estado):
        '''
        Aplicação de um operador a um determinado estado

        Parameters
        ----------
        estado :ArrumacaoEstado

        Returns
        -------
        estado :ArrumacaoEstado

        '''
        estado = self.agir.age(self.acao, estado)
        return estado
        
    
    def get_custo(self): 
        '''
        Devolve o custo do operador

        Returns
        -------
        TYPE :float
        '''
        return self.custo
        
    
    def get_acao(self):
        '''
        Devolve a ação associada ao operador

        Returns
        -------
        TYPE: acao

        '''
        return self.acao