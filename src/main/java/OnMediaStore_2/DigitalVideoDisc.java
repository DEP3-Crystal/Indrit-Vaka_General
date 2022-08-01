package OnMediaStore_2;

public class DigitalVideoDisc
{
    private String title;
    private Category category;
    private double cost;
    private String director;
    private int length;

    public DigitalVideoDisc()
    {
    }

    public DigitalVideoDisc(String title, Category category, double cost, String director, int length)
    {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
        this.length = length;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public double getCost()
    {
        return cost;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public String getDirector()
    {
        return director;
    }

    public void setDirector(String director)
    {
        this.director = director;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }


    @Override
    public String toString()
    {
        return String.format("%s|%s|%f|%s|%d", title, category.toString(), cost,director, length);
    }
}
enum Category{
    none,
    movie,
    sports,
    games
}
