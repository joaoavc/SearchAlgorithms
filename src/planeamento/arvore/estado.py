from abc import ABC, abstractmethod
class Estado(ABC):
    
    @abstractmethod
    def __eq__(self, other): raise NotImplementedError