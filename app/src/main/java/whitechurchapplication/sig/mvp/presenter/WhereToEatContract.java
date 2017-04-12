package whitechurchapplication.sig.mvp.presenter;



public interface WhereToEatContract {
    interface WhereToEatPresenter{
        void setView (WhereToEatView view);


        void getNumberOfLocationsInDb();
    }
    interface WhereToEatView{
        void showMessage(String message);
    }
}
