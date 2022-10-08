class MemoriaProcura:
    
    def __init__(self, fronteira):
        '''
        Memoria de Procura

        Parameters
        ----------
        fronteira :Queue
        '''
        self.fronteira = fronteira
        self.explorados = {}
        self.nos_da_fronteira = 0
        self.nos_explorados = 0
        
    
    def limpar(self):
        '''
        Limpeza da fronteira e dos nos já explorados
        '''
        self.fronteira.queue.clear()
        self.explorados.clear()

        
        
    def inserir(self, no, avaliacao):
        '''
        Inserir o No na memoria de pesquisa

        Parameters
        ----------
        no :No
        avaliacao :int
        '''
        estado = no.get_estado()
        no_explorado = self.explorados.get(estado)

        # Verifica se o no ja foi explorado
        if ((no_explorado == None)) :
            self.explorados[estado] = no
            self.fronteira.put((avaliacao, id(no), no))
            
            
    def remover(self):
        '''
        Remove o no da memoria de procura e devolve esse mesmo No
        Returns
        -------
        TYPE :No
        '''
        return self.fronteira.get()[2]
        
    
    def fronteira_vazia(self):
        '''
        Devolve true caso a fronteira esteja vazia

        Returns
        -------
        TYPE :boolean
        '''
        return self.fronteira.empty()