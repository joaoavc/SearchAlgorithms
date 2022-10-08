from procura import ProcuraMelhorPrimeiro

class ProcuraSofrega(ProcuraMelhorPrimeiro):
    
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
    
