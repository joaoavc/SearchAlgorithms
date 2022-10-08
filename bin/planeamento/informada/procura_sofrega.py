from procura import ProcuraMelhorPrimeiro
from procura import ProcuraHeuristica

class ProcuraSofrega(ProcuraMelhorPrimeiro, ProcuraHeuristica):
    
    def f(self, no):
        '''
       f(n) = h(n)

       Parameters
       ----------
       no : No

       Returns
       -------
       TYPE :float
       '''
        return super().get_problema().heuristica(no.get_estado())
    
